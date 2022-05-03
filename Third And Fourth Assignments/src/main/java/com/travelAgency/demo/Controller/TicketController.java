package com.travelAgency.demo.Controller;

import com.travelAgency.demo.Dto.Ticket.RequestTicketDto;
import com.travelAgency.demo.Dto.Ticket.ResponseTicketDto;
import com.travelAgency.demo.Enum.SeatType;
import com.travelAgency.demo.Exception.BiggerThanThreeDaysException;
import com.travelAgency.demo.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/book-ticket")
    public int bookTicket(@RequestBody RequestTicketDto requestTicketDto
                          , @RequestParam SeatType seatType){
        int ticketId = ticketService.saveTicket(requestTicketDto, seatType);
        return ticketId;
    }

    @GetMapping("/{ticket-id}")
    public ResponseTicketDto findTicketByTicketId ( @PathVariable(value = "ticket-id") int ticketId){
        ResponseTicketDto responseTicketDto = ticketService.findTicketByTicketId(ticketId);
        return responseTicketDto;
    }

    @DeleteMapping("/delete-ticket")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTicketByTicketId(@RequestParam int ticketId) throws BiggerThanThreeDaysException {
        ticketService.deleteTicket(ticketId);
    }

}
