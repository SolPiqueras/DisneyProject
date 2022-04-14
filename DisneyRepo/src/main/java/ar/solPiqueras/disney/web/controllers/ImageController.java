package ar.solPiqueras.disney.web.controllers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/image")
public class ImageController {



    @Builder
    @Getter
    @Setter
    @AllArgsConstructor
    public static class FileInfoResponse {
        private String name;
        private String type;
        private String url;
    }
}
