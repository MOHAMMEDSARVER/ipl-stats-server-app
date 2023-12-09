package com.example.iplstats.service;

import com.example.iplstats.domain.PlayerDetails;
import com.example.iplstats.dto.CountryCountStats;
import com.example.iplstats.dto.RoleAmountDto;
import com.example.iplstats.dto.TeamAmountStatsDto;
import com.example.iplstats.repo.IplStatsRepo;
import com.example.iplstats.service.exceptions.TeamNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class IplStatsServiceImpl implements IplStatsService {
    @Autowired
    IplStatsRepo iplStatsRepo;
    private String teamName;

    @Override
    public List<TeamAmountStatsDto> getTeamAmountStats() {
        List<TeamAmountStatsDto> teamAmountStats=iplStatsRepo.findTeamAmountStats();
        return teamAmountStats;
    }

    @Override
    public List<RoleAmountDto> getRoleAmountStats() {
        List<RoleAmountDto> roleAmountstats=iplStatsRepo.findRoleAmount();
        return roleAmountstats;
    }

    @Override
    public List<CountryCountStats> getCountryCountStats() {
        List<CountryCountStats> countryCountStats=iplStatsRepo.findCountryCount();
        return countryCountStats;
    }

    @Override
    public List<String> getTeamNames() {
        List<String> list=iplStatsRepo.getTeamNames();
        log.info("Total Team found:{}",list.size());
        return list;
    }

    @Override
    public List<PlayerDetails> getPlayersOf(String teamName) {
        Assert.notNull(teamName,"team Name should not be null.");
        if(!iplStatsRepo.existsByTeamName(teamName))
        {
            //throw exception
            throw new TeamNotFoundException("Team with name "+teamName+" not found");
        }
        List<PlayerDetails> playerDetails=iplStatsRepo.findByTeamName(teamName);
        return playerDetails;
    }

    @Override
    public List<RoleAmountDto> getRoleAmountStats(String teamName) {
        this.teamName = teamName;
        Assert.notNull(teamName,"team name should not be null");
        List<RoleAmountDto> list=iplStatsRepo.findRoleAmountOfTeam(teamName);
      return  list;
    }

    @Override
    public List<CountryCountStats> getCountryCountStats(String teamName, String roleName) {
        Assert.notNull(teamName,"team name should not be null");
        Assert.notNull(roleName,"role name should not be null");
        List<CountryCountStats> countryCountStats=iplStatsRepo.findCountryCount(teamName,roleName);
        return countryCountStats;
    }

    @Override
    public List<PlayerDetails> getAllPlayers() {
        log.info("total number of players found "+String.valueOf(iplStatsRepo.findAll().size()));
        return iplStatsRepo.findAll();
    }



}
