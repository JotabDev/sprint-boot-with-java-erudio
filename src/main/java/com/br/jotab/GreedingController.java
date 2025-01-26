package com.br.jotab;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class GreedingController {

	private static final String template = "hello, %s";
	private AtomicLong counter = new AtomicLong();
	
	@GetMapping("/greeding")
	public Greeding greeding(@RequestParam(value="name", defaultValue="world")
	String name) {
		return new Greeding(String.format(name, template), counter.incrementAndGet());
}
}