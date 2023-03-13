package com.cn.cnEvent.service;

import com.cn.cnEvent.dal.EventDAL;
import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.entity.Ticket;
import com.cn.cnEvent.exception.ElementAlreadyExistException;
import com.cn.cnEvent.exception.InvalidInputException;
import com.cn.cnEvent.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EventService {

	@Autowired
	EventDAL eventDAL;

	@Transactional
	public Event getEventById(Long id) {
		Event event=eventDAL.getById(id);
		if(event==null){
			throw new NotFoundException("No event found with id:  "+id);
		}
		return event;
	}

	@Transactional
	public List<Event> getAllEvents() {
		List<Event> events=eventDAL.getAllEvents();
		if(events==null){

			throw new NotFoundException("No events found.");
		}
		return events;
	}

	@Transactional
	public List<Event> getAllEventsByLocation(String location) {
		List<Event> events=eventDAL.getAllEventsByLocation(location);
		if(events==null){

			throw new NotFoundException("No events found for location: " + location);
		}
		return events;
	}

	@Transactional
	public EventScheduleDetail getEventScheduleDetailByEventId(Long id) {
		EventScheduleDetail eventScheduleDetail=eventDAL.getEventScheduleDetailByEventId(id);
		if(eventScheduleDetail==null){

			throw new NotFoundException("Event schedule detail not found for event with id: " + id);
		}
		return eventScheduleDetail;
	}

	//Complete the method body to get All ticket of an Event, given the event id. Also implement exception handling.
	public List<Ticket> getAllTicketsOfEvent(Long id) {
	}

	//Complete the method body to get All Events having any-one Ticket price greater than the given price.Also implement exception handling.
	public List<Event> getAllEventsHavingTicketPriceGreaterThan(Long price) {
	}

	@Transactional
	public String saveEvent(Event newEvent) {
		List<Event> allEvents = getAllEvents();
		for(Event event : allEvents)
		{
			if(event.getId()==newEvent.getId())
			{
				throw new ElementAlreadyExistException("This event already exist.");
			}
		}
		try {
			return eventDAL.save(newEvent);
		}
		catch (Exception e)
		{
			throw new InvalidInputException("The input entity for event is invalid.");
		}
	}

	@Transactional
	public String delete(Long id) {
		List<Event> allEvents = getAllEvents();

		boolean isEntityPresent=false;
		for(Event event : allEvents)
		{
			if(event.getId()==id)
			{
				isEntityPresent=true;
			}
		}
		if(isEntityPresent==false)
		{
			throw new InvalidInputException("This event doesn't exist.");
		}
		try{
			return eventDAL.delete(id);
		}
		catch (Exception e){
			throw new InvalidInputException("Error in deleting event.");
		}
	}

	@Transactional
	public String deleteEventScheduleDetail(Long id) {
		try{
			return eventDAL.deleteEventScheduleDetail(id);
		}
		catch (Exception e){
			throw new InvalidInputException("Error in deleting eventScheduleDetail from event.");
		}
	}

	@Transactional
	public String update(Event updateEvent) {
		try{
			return eventDAL.update(updateEvent);
		}
		catch (Exception e){
			throw new InvalidInputException("Error in deleting eventScheduleDetail from event.");
		}
	}
}
