package com.nighthawk.spring_portfolio.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nighthawk.spring_portfolio.mvc.calendar.APCalendar;
import com.nighthawk.spring_portfolio.mvc.calendar.Year;

/**
 * Calendar API
 * Calendar Endpoint: /api/calendar/isLeapYear/2022, Returns:
 * {"year":2020,"isLeapYear":false}
 */

@RestController
@RequestMapping("/api/calendar")
public class CalendarApiController {

  /**
   * GET isLeapYear endpoint
   * ObjectMapper throws exceptions on bad JSON
   * 
   * @throws JsonProcessingException
   * @throws JsonMappingException
   */
  @GetMapping("/isLeapYear/{year}")
  public ResponseEntity<JsonNode> getIsLeapYear(@PathVariable int year)
      throws JsonMappingException, JsonProcessingException {
    // Backend Year Object
    Year year_obj = new Year();
    year_obj.setYear(year); // evaluates Leap Year

    // Turn Year Object into JSON
    ObjectMapper mapper = new ObjectMapper();
    JsonNode json = mapper.readTree(year_obj.isLeapYearToString()); // this requires exception handling

    return ResponseEntity.ok(json); // JSON response, see ExceptionHandlerAdvice for throws
  }

  // add other methods

  @GetMapping("/firstDayOfYear/{year}")
  public ResponseEntity<String> getFirstDayOfYear(@PathVariable int year)
      throws JsonMappingException, JsonProcessingException {

    int firstDayOfYear = APCalendar.firstDayOfYear(year);
    return ResponseEntity.ok("FirstDayOfYear for year -  " + year + " is : " + firstDayOfYear); // JSON response, see ExceptionHandlerAdvice for throws
  }

  @GetMapping("/numberOfLeapYears/{year1}/{year2}")
  public ResponseEntity<String> getNumberOfLeapYears(@PathVariable int year1, @PathVariable int year2)
      throws JsonMappingException, JsonProcessingException {

    int noOfLeapYears = APCalendar.numberOfLeapYears(year1, year2);
    return ResponseEntity.ok("Number of Leap years between -  " + year1 
    + " and " + year2 + " are : " + noOfLeapYears); 
  }

}