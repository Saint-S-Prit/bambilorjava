package sn.saint.bambilorjava.service;


import sn.saint.bambilorjava.model.Appuser;

public interface ApplicationService {
    public Appuser findByUsername(String username);
}
