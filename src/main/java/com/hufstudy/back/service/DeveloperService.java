package com.hufstudy.back.service;

import com.hufstudy.back.domain.Developer;
import com.hufstudy.back.domain.File;

public interface DeveloperService {
    Developer updateShortBio(Long developerId, String shortBio);
    Developer updateIntroduction(Long developerId, String introduction);

}
