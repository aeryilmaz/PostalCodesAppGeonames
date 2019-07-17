package com.aeryilmaz.springboot.app.controller;

import com.aeryilmaz.springboot.app.model.PostalCodeViewModel;
import com.aeryilmaz.springboot.app.service.PostalCodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postalcodes")
public class PostalCodeRestController {
    private final PostalCodeService m_postalCodeService;

    public PostalCodeRestController(PostalCodeService postalCodeService)
    {
        m_postalCodeService = postalCodeService;
    }

    @GetMapping("/postalcode")
    public Iterable<PostalCodeViewModel> getPostalCodesAsString(
            @RequestParam("code") String postalCode,
            @RequestParam(value = "country", required = false, defaultValue = "") String countryCode)
    {
        return m_postalCodeService.getPostalCode(postalCode, countryCode);
    }
}
