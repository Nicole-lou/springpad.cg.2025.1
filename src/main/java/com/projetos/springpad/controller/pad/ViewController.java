/**
 * com.projetos.springpad.controller.pad.ViewController
 * Exibe os detalhes do "pad" selecionado pelo `pad.id`
 */

package com.projetos.springpad.controller.pad;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/view")
    public String ViewPad(Model model) {

        model.addAttribute("title", "Title do pad");
        return "pad/view";
    }

}
