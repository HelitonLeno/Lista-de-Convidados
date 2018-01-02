package br.com.tonsoft.lista.controller;

import br.com.tonsoft.lista.model.Convidado;
import br.com.tonsoft.lista.repository.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ConvidadoController {
    @Autowired
    private ConvidadoRepository cr;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/listaconvidados")
    public String listaConvidados(Model model) {
        Iterable<Convidado> convidados = cr.findAll();
        model.addAttribute("convidados", convidados);
        return "listaconvidados";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute(new Convidado());
        return "novo_convidado";
    }

    @PostMapping("/novo")
    public String salvar(@Valid Convidado convidado, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "novo_convidado";
        }
        cr.save(convidado);
        return "redirect:/listaconvidados";
    }

    @GetMapping("/{id}")
    public String deletar(long id) {
        Convidado convidado = cr.findById(id);
        cr.delete(convidado);

        return "redirect:/listaconvidados";
    }

}
