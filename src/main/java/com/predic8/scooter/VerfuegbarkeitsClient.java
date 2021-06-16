//package com.predic8.scooter;
//
//import com.predic8.scooter.model.Verfuegbarkeit;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.ResponseEntity;
//import org.springframework.retry.annotation.Retryable;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@FeignClient(name = "verfuegbarkeitsService", url = "http://localhost:8081/")
//public interface VerfuegbarkeitsClient {
//
////    @Retryable(maxAttempts = 5)
//    @RequestMapping(method = RequestMethod.GET, value = "/scooter/{id}/verfuegbarkeit")
//    ResponseEntity<Verfuegbarkeit> pruefeVerfuegbarkeit(@PathVariable("id") String id);
//}
