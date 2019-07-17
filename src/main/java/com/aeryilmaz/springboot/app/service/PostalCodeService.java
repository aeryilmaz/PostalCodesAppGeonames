package com.aeryilmaz.springboot.app.service;

import com.aeryilmaz.springboot.app.entity.PostalCodeInfo;
import com.aeryilmaz.springboot.app.model.PostalCodeViewModel;
import com.aeryilmaz.springboot.app.model.PostalCodesModel;
import com.aeryilmaz.springboot.app.repository.IPostalCodeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PostalCodeService {
    @Autowired
    private RestTemplate m_restTemplate;

    @Autowired
    private IPostalCodeRepository m_postalCodeRepository;

    @Autowired
    private ModelMapper m_modelMapper;

    @Value("${geonames.url}")
    private String m_url;

    private List<PostalCodeViewModel> savePostalCodes(String postalCode, String countryCode)
    {
        var postalCodeInfos = getPostalCodeFromGeonames(postalCode, countryCode).getPostalCodes();

        m_postalCodeRepository.saveAll(postalCodeInfos);

        return postalCodeInfos
                .stream()
                .map(pi -> m_modelMapper.map(pi, PostalCodeViewModel.class))
                .collect(Collectors.toList());
    }

    private Iterable<PostalCodeViewModel> convertToViewModels(Iterable<PostalCodeInfo> postalCodeInfos)
    {
        return StreamSupport.stream(postalCodeInfos.spliterator(), false)
                .map(pi -> m_modelMapper.map(pi, PostalCodeViewModel.class)).collect(Collectors.toList());
    }

    private PostalCodesModel getPostalCodeFromGeonames(String postalCode, String countryCode)
    {
        String url = String.format(m_url, postalCode, countryCode.isEmpty() ? "tr" : countryCode);

        return m_restTemplate.getForObject(url, PostalCodesModel.class);
    }

    public Iterable<PostalCodeViewModel> getPostalCode(String postalCode, String countryCode)
    {
        countryCode = countryCode.isEmpty() ? "TR" : countryCode.toUpperCase();

        if (!m_postalCodeRepository.existsByPostalCodeAndCountryCode(postalCode, countryCode))
            return savePostalCodes(postalCode, countryCode);

        return convertToViewModels(m_postalCodeRepository.findByPostalCodeAndCountryCode(postalCode, countryCode));
    }
}










