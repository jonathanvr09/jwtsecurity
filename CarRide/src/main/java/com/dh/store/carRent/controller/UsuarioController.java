package com.dh.store.carRent.controller;

import com.dh.store.carRent.dto.PageResponseDTO;
import com.dh.store.carRent.dto.UserDTO;
import com.dh.store.carRent.dto.UserPageDTO;
import com.dh.store.carRent.model.UsuarioModel;
import com.dh.store.carRent.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@AllArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Operation(security = { @SecurityRequirement(name = "bearer-key") },summary = "Get page of users",
            parameters = { @Parameter(in = ParameterIn.QUERY, name = "page", description = "Page"),
                    @Parameter(in = ParameterIn.QUERY, name = "size", description = "Size") },
            responses = {
                    @ApiResponse(responseCode = "200",description = "Successful Operation",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = UserPageDTO.class)))})
    @GetMapping ("/api/users")
    public PageResponseDTO<UserDTO> getUsers(@PageableDefault(size = 10,page = 0) @ParameterObject Pageable pageable) {
        return usuarioService.getUsers(pageable);
    }

    @GetMapping
    public ArrayList<UsuarioModel> listar(){
        return usuarioService.listar();
    }

    @PostMapping
    public UsuarioModel crear(@RequestBody UsuarioModel usuario){
        return this.usuarioService.crear(usuario);
    }

    @DeleteMapping("/{email}/")
    public boolean eliminar(@PathVariable("email") String email) {
        return usuarioService.eliminar(email);
    }

}
