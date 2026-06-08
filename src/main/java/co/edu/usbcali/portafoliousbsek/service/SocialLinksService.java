package co.edu.usbcali.portafoliousbsek.service;

import co.edu.usbcali.portafoliousbsek.dto.SocialLinkRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.SocialLinkResponseDTO;

import java.util.List;

public interface SocialLinksService {
    List<SocialLinkResponseDTO> getSocialLinks();
    SocialLinkResponseDTO findSocialLinkById(Integer id);
    SocialLinkResponseDTO saveSocialLink(SocialLinkRequestDTO socialLink) throws Exception;
    SocialLinkResponseDTO updateSocialLink(Integer id, SocialLinkRequestDTO socialLink) throws Exception;
}
