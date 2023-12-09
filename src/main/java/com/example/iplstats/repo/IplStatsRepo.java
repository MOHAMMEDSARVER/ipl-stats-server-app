package com.example.iplstats.repo;

import com.example.iplstats.domain.PlayerDetails;
import com.example.iplstats.dto.CountryCountStats;
import com.example.iplstats.dto.RoleAmountDto;
import com.example.iplstats.dto.TeamAmountStatsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IplStatsRepo extends JpaRepository<PlayerDetails, Long> {
    @Query("select distinct p.teamName from PlayerDetails p")
    List<String> getTeamNames();

    @Query("select new com.example.iplstats.dto.TeamAmountStatsDto(p.teamName teamName,sum(p.amount) totalAmount) from PlayerDetails p group by p.teamName")
    List<TeamAmountStatsDto> findTeamAmountStats();

    List<PlayerDetails> findByTeamName(String teamName);

    @Query("select new com.example.iplstats.dto.RoleAmountDto(p.roleName roleName, sum(p.amount) totalAmount) from PlayerDetails p group by p.roleName")
    List<RoleAmountDto> findRoleAmount();

    @Query("select new com.example.iplstats.dto.RoleAmountDto(p.roleName roleName, sum(p.amount) totalAmount) from PlayerDetails  p where p.teamName=:teamName group by p.roleName")
    List<RoleAmountDto> findRoleAmountOfTeam(@Param("teamName") String team);

    @Query("select new com.example.iplstats.dto.CountryCountStats(p.countryName countryName,count(name) count) from PlayerDetails p group by p.countryName")
    List<CountryCountStats> findCountryCount();

    @Query("select new com.example.iplstats.dto.CountryCountStats(p.countryName countryName,count(name) count) from PlayerDetails p where p.teamName=:teamName and p.roleName=:roleName group by p.countryName")
    List<CountryCountStats> findCountryCount(@Param("teamName") String teamName, @Param("roleName") String roleName);

    boolean existsByTeamName(String teamName);

}
