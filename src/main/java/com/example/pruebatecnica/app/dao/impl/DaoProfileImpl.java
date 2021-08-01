package com.example.pruebatecnica.app.dao.impl;

import com.example.pruebatecnica.app.dao.models.Profile;
import com.example.pruebatecnica.app.dao.repositories.ProfileRepository;
import com.example.pruebatecnica.app.dao.specification.DaoProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DaoProfileImpl implements DaoProfile {

    private final ProfileRepository profileRepository;

    @Override
    public Profile searchProfile(Integer id) {
        return profileRepository.getById(id);
    }
}
