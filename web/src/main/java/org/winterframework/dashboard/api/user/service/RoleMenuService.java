package org.winterframework.dashboard.api.user.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.winterframework.dashboard.api.user.entity.RoleMenu;
import org.winterframework.dashboard.api.user.mapper.RoleMenuMapper;

import java.util.List;

/**
 * @author Kyun
 * @since 2022-05-26
 */
@Service
public class RoleMenuService extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IService<RoleMenu> {

    public void deleteByRoleIds(List<Integer> ids) {
        this.remove(Wrappers.lambdaQuery(RoleMenu.class).in(RoleMenu::getRoleId, ids));
    }

    public List<Integer> getRoleMenuIds(Integer id) {
        return baseMapper.getMenuIdsByRoleId(id);
    }
}
