package com.FerresaswebV1.Ferresasweb.view;

import com.FerresaswebV1.Ferresasweb.model.Usuarios;
import com.FerresaswebV1.Ferresasweb.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/view/usuarios")
public class UsuariosView {

    @Autowired
    private UsuariosRepository usuariosRepository;

    // 1. Mostrar la lista de usuarios en una vista HTML
    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuariosRepository.findAll());
        return "usuarios/list"; // Nombre de tu archivo HTML de listado (ajústalo si es diferente)
    }

    // 2. Mostrar el formulario para crear un nuevo usuario
    @GetMapping("/nuevo")
    public String nuevoUsuarioForm(Model model) {
        model.addAttribute("usuarios", new Usuarios());
        return "usuarios/form"; // Nombre de tu archivo HTML de formulario
    }

    // 3. Mostrar el formulario para EDITAR un usuario (¡Aquí es donde se solucionaba tu 404!)
    @GetMapping("/editar/{id}")
    public String editarUsuarioForm(@PathVariable Long id, Model model) {
        Usuarios usuario = usuariosRepository.findById(id).orElse(new Usuarios());
        model.addAttribute("usuarios", usuario);
        return "usuarios/form"; // Reutiliza el mismo form.html cargando los datos
    }

    // 4. Guardar o actualizar los datos que vienen del formulario
    @PostMapping("/save")
    public String save(@ModelAttribute Usuarios usuarios, RedirectAttributes redirectAttributes) {
        usuariosRepository.save(usuarios);
        return "redirect:/view/usuarios"; // Redirige a la lista después de guardar
    }

    // 5. Eliminar un usuario
    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuariosRepository.deleteById(id);
        return "redirect:/view/usuarios";
    }
}