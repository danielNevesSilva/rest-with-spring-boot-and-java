package br.com.erudio.apigateway.controller;


import br.com.erudio.apigateway.services.BookServices;
import br.com.erudio.apigateway.util.MediaType;
import br.com.erudio.apigateway.vo.v1.BookVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book/v1")
@Tag(name = "Book", description = "Endpoites for managing Book")
public class BookController {
        @Autowired
        private BookServices service;

        @GetMapping(produces = { MediaType.APPLICATION_JSON,
                MediaType.APPLICATION_XML,
                MediaType.APPLICATION_YML})
        @Operation(summary = "Finds all Book", description = "Find all Book",
        tags = {"Book"},
        responses = {
                @ApiResponse(description = "success" , responseCode = "200",
                        content = {
                         @Content(
                                mediaType = "application/json",
                                array = @ArraySchema(schema = @Schema(implementation = BookVO.class))
                         )
                                 }),
                @ApiResponse(description = "Bad Request" , responseCode = "400", content = {@Content}),
                @ApiResponse(description = "Unauthorized" , responseCode = "401", content = {@Content}),
                @ApiResponse(description = "Bad Not Found" , responseCode = "404", content = {@Content}),
                @ApiResponse(description = "Bad Internal Error" , responseCode = "500", content = {@Content})
         }
        )
        public List<BookVO> findAll() {
            return service.findAll();
        }

        @GetMapping(value = "/{id}",
                produces = { MediaType.APPLICATION_JSON,
                        MediaType.APPLICATION_XML,
                        MediaType.APPLICATION_YML})
        @Operation(summary = "Finds a Book", description = "Find a Book",
                tags = {"Book"},
                responses = {
                        @ApiResponse(description = "success" , responseCode = "200",
                                content = @Content(schema = @Schema(implementation = BookVO.class))
                                ),
                        @ApiResponse(description = "No content" , responseCode = "204", content = {@Content}),
                        @ApiResponse(description = "Bad Request" , responseCode = "400", content = {@Content}),
                        @ApiResponse(description = "Unauthorized" , responseCode = "401", content = {@Content}),
                        @ApiResponse(description = "Bad Not Found" , responseCode = "404", content = {@Content}),
                        @ApiResponse(description = "Bad Internal Error" , responseCode = "500", content = {@Content})
                }
        )
        public BookVO findById(@PathVariable(value = "id") Long id) {
            return service.findById(id);
        }

        @PostMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML },
                produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
        @Operation(summary = "Adds a new Book", description = "Adds a new Book",
                tags = {"Book"},
                responses = {
                        @ApiResponse(description = "success" , responseCode = "200",
                                content = @Content(schema = @Schema(implementation = BookVO.class))
                        ),
                        @ApiResponse(description = "Bad Request" , responseCode = "400", content = {@Content}),
                        @ApiResponse(description = "Unauthorized" , responseCode = "401", content = {@Content}),
                        @ApiResponse(description = "Bad Not Found" , responseCode = "404", content = {@Content}),
                        @ApiResponse(description = "Bad Internal Error" , responseCode = "500", content = {@Content})
                }
        )
        public BookVO create(@RequestBody BookVO Book) {
            return service.create(Book);
        }


    @PutMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML },
                produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })

    @Operation(summary = "Updates a Book", description = "Updates a Book",
            tags = {"Book"},
            responses = {
                    @ApiResponse(description = "success" , responseCode = "200",
                            content = @Content(schema = @Schema(implementation = BookVO.class))
                    ),
                    @ApiResponse(description = "Bad Request" , responseCode = "400", content = {@Content}),
                    @ApiResponse(description = "Unauthorized" , responseCode = "401", content = {@Content}),
                    @ApiResponse(description = "Bad Not Found" , responseCode = "404", content = {@Content}),
                    @ApiResponse(description = "Bad Internal Error" , responseCode = "500", content = {@Content})
            }
    )
    public BookVO update(@RequestBody BookVO Book) {
            return service.update(Book);
        }


        @DeleteMapping(value = "/{id}")
        @Operation(summary = "Delete a Book", description = "Delete a Book",
                tags = {"Book"},
                responses = {
                        @ApiResponse(description = "No Content" , responseCode = "204",
                                content = @Content
                        ),
                        @ApiResponse(description = "Bad Request" , responseCode = "400", content = {@Content}),
                        @ApiResponse(description = "Unauthorized" , responseCode = "401", content = {@Content}),
                        @ApiResponse(description = "Bad Not Found" , responseCode = "404", content = {@Content}),
                        @ApiResponse(description = "Bad Internal Error" , responseCode = "500", content = {@Content})
                }
        )
        public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
}
