package org.system.ticketsystem.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.system.ticketsystem.entity.Ticket;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Long> {

    @Query("FROM Ticket WHERE clientemail = :email and paymentvalue is not null AND isConfirmed = FALSE ORDER BY creationdate DESC")
    List<Ticket> findByEmailForPaymentRequest(String email);

    @Query("FROM Ticket WHERE clientemail = :email and paymentvalue is not null AND isConfirmed = FALSE AND requesttype <> :reqType ORDER BY creationdate DESC")
    List<Ticket> findByEmailForPaymentRequestIgnoreReqType(String email, String reqType);


    @Query("FROM Ticket where paymentid = :paymentId")
    Optional<Ticket> findByPaymentid(String paymentId);

    @Query("FROM Ticket t where t.ticketid = :ticketId")
    Optional<Ticket> findByTicketId(String ticketId);

    @Query("FROM Ticket where senderRequestNumber = :senderRequestNumber and  isConfirmed = :isConfirmed")
    Optional<Ticket> findConfirmedTkt(String senderRequestNumber, boolean isConfirmed);
//
//    @Query(value = "SELECT * FROM TICKET t where t.SENDERREQUESTNUMBER = :senderRequestNumber and t.ISCONFIRMED = :isConfirmed", nativeQuery = true)
//    Optional<Ticket> findConfirmedTkt(String senderRequestNumber, Integer isConfirmed);
}
