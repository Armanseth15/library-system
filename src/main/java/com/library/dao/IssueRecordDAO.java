package com.library.dao;

import com.library.entity.Book;
import com.library.entity.IssueRecord;
import com.library.entity.Member;
import com.library.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;

public class IssueRecordDAO {

    public void issueBook(Integer bookId, Integer memberId) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Book book = session.get(Book.class, bookId);
            Member member = session.get(Member.class, memberId);

            if (book == null) {
                throw new RuntimeException("Book not found.");
            }

            if (member == null) {
                throw new RuntimeException("Member not found.");
            }

            if (book.getQuantity() <= 0) {
                throw new RuntimeException("Book is out of stock.");
            }

            book.setQuantity(book.getQuantity() - 1);

            IssueRecord record = new IssueRecord(book, member, LocalDate.now(), "ISSUED");

            session.merge(book);
            session.persist(record);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public void returnBook(Integer issueId) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            IssueRecord record = session.get(IssueRecord.class, issueId);

            if (record == null) {
                throw new RuntimeException("Issue record not found.");
            }

            if ("RETURNED".equalsIgnoreCase(record.getStatus())) {
                throw new RuntimeException("Book already returned.");
            }

            Book book = record.getBook();
            book.setQuantity(book.getQuantity() + 1);

            record.setStatus("RETURNED");
            record.setReturnDate(LocalDate.now());

            session.merge(book);
            session.merge(record);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public List<IssueRecord> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from IssueRecord order by id desc", IssueRecord.class).list();
        }
    }
}