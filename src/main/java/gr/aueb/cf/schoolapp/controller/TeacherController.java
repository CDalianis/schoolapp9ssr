package gr.aueb.cf.schoolapp.controller;

import gr.aueb.cf.schoolapp.dto.TeacherInsertDTO;
import gr.aueb.cf.schoolapp.dto.TeacherReadOnlyDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    @GetMapping("/insert")
    public String getTeacherForm(Model model) {
        model.addAttribute("teacherInsertDTO", TeacherInsertDTO.empty());
        //model.addAttribute("RegionReadOnlyDTO",regions());
        return "teacher-insert";
    }

    public String teacherInsert (@Valid @ModelAttribute("teacherInsertDTO")TeacherInsertDTO teacherInsertDTO,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "teacher-insert";
        }
        TeacherReadOnlyDTO teacherReadOnlyDTO = new TeacherReadOnlyDTO("acfd-1234","Aθανάσιος","Ανδρουτσος");
        model.addAttribute("teacherReadOnlyDTO", teacherReadOnlyDTO);
        return "redirect:/teacher-success";
    }


    @GetMapping("/success")
    public String teacherSuccess(Model model) {
        return "teacher-success";
    }

    @ModelAttribute("regionsReadOnlyDTO")
    public List<RegionsReadOnlyDTO> regions() {
        return List.of(
                new RegionsReadOnlyDTO(1L, "Athens"),
                new RegionsReadOnlyDTO(2L,"Volos"),
                new RegionsReadOnlyDTO(3L, "Thessaloniki"));

    }


}
