package com.br.jotab.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.jotab.data.vo.v1.PersonVO;
// import com.br.jotab.data.vo.v2.PersonVOv2;
import com.br.jotab.services.PersonServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/person/v1")
@Tag(name = "People", description = "EndPointer for Mananging in People")
public class PersonController {

	@Autowired
	PersonServices services;

//	@RequestMapping(value = "/{id}", 
	// method = RequestMethod.GET,
	// produces = MediaType.APPLICATION_JSON_VALUE)

	@GetMapping("/{id}")
	@Operation(summary = "Finds a Person", description = "Finds a Person", tags = { "People" }, responses = {
			@ApiResponse(description = "Sucess", responseCode = "200", content = @Content(schema = @Schema(implementation = PersonVO.class))),

			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), }

	)
	public PersonVO findById(@PathVariable() Long id) {
		return services.findById(id);
	}

	@PostMapping
	@Operation(summary = "Insertion one Person", description = "Insertion one Person", tags = { "People" }, responses = {
			@ApiResponse(description = "Sucess", responseCode = "200", content = @Content(schema = @Schema(implementation = PersonVO.class))),

			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), }

	)
	public PersonVO create(@RequestBody PersonVO person) {
		return services.create(person);
	}
	/*
	 * @PostMapping("/v2") public PersonVOv2 createV2(@RequestBody PersonVOv2
	 * personVOv2) { return services.createV2(personVOv2); }
	 */

	@PutMapping
	@Operation(summary = "Update one Person", description = "Update one Person", tags = { "People" }, responses = {
			@ApiResponse(description = "Updated", responseCode = "200", content = @Content(schema = @Schema(implementation = PersonVO.class))),

			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), }

	)
	public PersonVO update(@RequestBody PersonVO person) {
		return services.update(person);
	}

	// inclusion of ResponseEntity is application StatusCode
	@DeleteMapping("/{id}")
	@Operation(summary = "Deleting one Person", description = "Deleting one Person", tags = { "People" }, responses = {
			@ApiResponse(description = "NO Content", responseCode = "204", content = @Content(schema = @Schema(implementation = PersonVO.class))),

	
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), }

	)
	public ResponseEntity<?> delete(@PathVariable() Long id) {
		services.delete(id);

		return ResponseEntity.noContent().build();
	}

	@GetMapping
	@Operation(summary = "Finds All People", description = "Finds All People", tags = { "People" }, responses = {
			@ApiResponse(description = "Sucess", responseCode = "200", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PersonVO.class))) }),

			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), }

	)

	public List<PersonVO> findAll() {
		return services.findByAll();
	}

}
