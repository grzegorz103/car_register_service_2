package uph.tpsi.services;

import uph.tpsi.models.CarRegister;

import java.util.List;

public interface CarRegisterService
{
        CarRegister create(Long id);

        CarRegister pay(Long id);

        List<CarRegister> findAll();
}
