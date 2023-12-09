package com.example.iplstats.service;

import com.example.iplstats.domain.PlayerDetails;
import com.example.iplstats.dto.CountryCountStats;
import com.example.iplstats.dto.RoleAmountDto;
import com.example.iplstats.dto.TeamAmountStatsDto;

import java.util.List;

public interface IplStatsService {
    List<TeamAmountStatsDto> getTeamAmountStats();
    List<RoleAmountDto> getRoleAmountStats();
    List<CountryCountStats> getCountryCountStats();
    List<String> getTeamNames();
    List<PlayerDetails> getPlayersOf(String teamName);
    List<RoleAmountDto> getRoleAmountStats(String teamName);
    List<CountryCountStats> getCountryCountStats(String teamName, String roleName);

    List<PlayerDetails> getAllPlayers();


    /*ProblemDetail geAllPlayers();*/
}
