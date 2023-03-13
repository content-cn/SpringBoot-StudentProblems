 package com.cn.cnEvent.controller;

 import com.cn.cnEvent.entity.Event;
 import com.cn.cnEvent.entity.EventScheduleDetail;
 import com.cn.cnEvent.entity.Ticket;
 import com.cn.cnEvent.service.EventService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;

 import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	EventService eventService;

	@GetMapping("/id/{id}")
	public Event getEventById(@PathVariable Long id)
	{
		Event event=eventService.getEventById(id);
		return event;
	}

	@GetMapping("/allEvents")
	public List<Event> getAllEvents()
	{
		return eventService.getAllEvents();
	}

	@GetMapping("/allEvents/location/{location}")
	public List<Event> getAllEventsByLocation(@PathVariable String location)
	{
		return eventService.getAllEventsByLocation(location);
	}

	@GetMapping("/id/{id}/eventScheduleDetail")
	public EventScheduleDetail getEventScheduleDetailByEventId(@PathVariable Long id)
	{
		return eventService.getEventScheduleDetailByEventId(id);
	}

	/*
     1. Call the required service method
     2. Add proper annotations for Get Mapping and fetch the
         id from URL using PathVariable.
*/
	public List<Ticket> getAllTicketsOfEvent(@PathVariable Long id)
	{
	}

	/*
     1. Call the required service method
     2. Add proper annotations for Get Mapping and fetch the
         price from URL using PathVariable.
    */
	public List<Event> getAllEventsHavingTicketPriceGreaterThan(@PathVariable Long price)
	{
	}
	
	@PostMapping("/save")
	public  String saveEvent(@RequestBody Event event)
	{
		return eventService.saveEvent(event);
	}
	
	@DeleteMapping("/delete/id/{id}")
	public String deleteEvent(@PathVariable Long id)
	{
		return eventService.delete(id);
	}

	@DeleteMapping("/deleteEventScheduleDetail/id/{id}")
	public String deleteEventScheduleDetail(@PathVariable Long id)
	{
		return eventService.deleteEventScheduleDetail(id);
	}

	@PutMapping("/update")
	public String updateEvent(@RequestBody Event updateEvent)
	{
		return eventService.update(updateEvent);
	}

}
