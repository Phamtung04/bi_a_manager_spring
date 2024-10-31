package com.eaut.quanlybia.service;

import com.eaut.quanlybia.DTO.BanDto;
import com.eaut.quanlybia.Entity.Ban;
import com.eaut.quanlybia.Mapper.BanMapper;
import com.eaut.quanlybia.form.Ban.BanCreateForm;
import com.eaut.quanlybia.form.Ban.BanUpdateForm;
import com.eaut.quanlybia.repository.BanRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BanServiceIpml implements BanService{
    private BanRepository banRepository;

    @Override
    public BanDto create(BanCreateForm form) {
        var ban = BanMapper.map(form);
        ban.setTinhTrang(String.valueOf(Ban.TinhTrang.DONG));
        var savaBan = banRepository.save(ban);
        return BanMapper.map(savaBan);
    }

    @Override
    public Page<BanDto> findAll(Pageable pageable) {
        return banRepository.findAll(pageable).map(BanMapper :: map);
    }

    @Override
    public BanDto update(BanUpdateForm form, Integer mb) {
        var ban = banRepository.findById(mb).get();
        BanMapper.map(form, ban);
        var saveBan = banRepository.save(ban);
        return BanMapper.map(saveBan);
    }

    @Override
    public void deleteByMaBan(Integer mb) {
        banRepository.deleteById(mb);
    }

}
