package com.example.iplstats.controller;

import com.example.iplstats.domain.PlayerDetails;
import com.example.iplstats.dto.CountryCountStats;
import com.example.iplstats.dto.RoleAmountDto;
import com.example.iplstats.dto.TeamAmountStatsDto;
import com.example.iplstats.service.IplStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class IplStatsController {
    @Autowired
    IplStatsService iplStatsService;

    @GetMapping("/teamnames")
    public ResponseEntity<List<String>> getTeamNames() {
        return ResponseEntity.of(Optional.ofNullable(iplStatsService.getTeamNames()));
    }

    @GetMapping("/teamamountstat")
    public ResponseEntity<List<TeamAmountStatsDto>> getTeamAmountStats() {
        return ResponseEntity.of(Optional.ofNullable(iplStatsService.getTeamAmountStats()));
    }



    @GetMapping("/roleamountstats")
    public ResponseEntity<List<RoleAmountDto>> getRoleAmountstats() {
        return ResponseEntity.ok(iplStatsService.getRoleAmountStats());
    }
    @GetMapping("/teamroleamountstats/{teamName}")
    public ResponseEntity<List<RoleAmountDto>> getTeamRoleAmontStats(@PathVariable("teamName") String teamName){
       List<RoleAmountDto> list=iplStatsService.getRoleAmountStats(teamName);
       return ResponseEntity.ok(list);
    }

    @GetMapping("players/{teamName}")
    public ResponseEntity<List<PlayerDetails>> getPlayersOfTeam(@PathVariable("teamName") String teamName) {
        List<PlayerDetails> playerDetails = iplStatsService.getPlayersOf(teamName);
        return ResponseEntity.ok(playerDetails);
    }

    @GetMapping("/players")
    public ResponseEntity<List<PlayerDetails>> getAllPlayers() {
        return ResponseEntity.of(Optional.ofNullable(iplStatsService.getAllPlayers()));
    }



    @GetMapping("/countrycountstats")
    public ResponseEntity<List<CountryCountStats>> getCountryCount() {
        return ResponseEntity.ok(iplStatsService.getCountryCountStats());
    }

    @GetMapping("countrycountstats/{teamName}/{roleName}")
    public ResponseEntity<List<CountryCountStats>> getCountryCountStats(@PathVariable("teamName") String teamName,@PathVariable("roleName") String roleName)
    {
        return ResponseEntity.ok(iplStatsService.getCountryCountStats(teamName,roleName));
    }

}
