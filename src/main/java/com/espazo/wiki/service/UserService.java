package com.espazo.wiki.service;

import com.espazo.wiki.domain.User;
import com.espazo.wiki.domain.UserExample;
import com.espazo.wiki.exception.BusinessException;
import com.espazo.wiki.exception.BusinessExceptionCode;
import com.espazo.wiki.mapper.UserMapper;
import com.espazo.wiki.req.UserQueryReq;
import com.espazo.wiki.req.UserResetPasswordReq;
import com.espazo.wiki.req.UserSaveReq;
import com.espazo.wiki.resp.PageResp;
import com.espazo.wiki.resp.UserQueryResp;
import com.espazo.wiki.util.CopyUtil;
import com.espazo.wiki.util.SnowFlake;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private SnowFlake snowFlake;

    public PageResp<UserQueryResp> list(UserQueryReq req) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();

        if (!ObjectUtils.isEmpty(req.getLoginName())) {
            criteria.andLoginNameEqualTo(req.getLoginName());
        }

        PageHelper.startPage(req.getPage(), req.getSize());
        List<User> userList = userMapper.selectByExample(userExample);

        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        LOG.info("总行数：{}", userPageInfo.getTotal());
        LOG.info("总页数：{}", userPageInfo.getPages());

//        List<UserResp> respList = new ArrayList<>();
//        for (User user : userList) {
////            UserResp userResp = new UserResp();
////            BeanUtils.copyProperties(user, userResp);
//
//            UserResp userResp = CopyUtil.copy(user, UserResp.class);
//
//            respList.add(userResp);
//        }

        List<UserQueryResp> list = CopyUtil.copyList(userList, UserQueryResp.class);
        PageResp<UserQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(userPageInfo.getTotal());
        pageResp.setList(list);

        return pageResp;
    }

    /**
     * 保存
     */
    public void save(UserSaveReq req) {
        User user = CopyUtil.copy(req, User.class);
        if (ObjectUtils.isEmpty(req.getId())) {
            // 新增
            User userDB = selectByLoginName(req.getLoginName());
            if (ObjectUtils.isEmpty(userDB)) {
                user.setId(snowFlake.nextId());
                userMapper.insert(user);
            } else {
                // 用户名已经存在
//                throw new RuntimeException("用户名已经存在");
                throw new BusinessException(BusinessExceptionCode.USER_LOGIN_NAME_EXIST);
            }
        } else {
            // 更新
            user.setLoginName(null);
            user.setPassword(null);
            userMapper.updateByPrimaryKeySelective(user);
        }
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    public User selectByLoginName(String LoginName) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andLoginNameEqualTo(LoginName);
        List<User> userList = userMapper.selectByExample(userExample);

        if (CollectionUtils.isEmpty(userList)) {
            return null;
        } else {
            return userList.get(0);
        }
    }

    /**
     * 修改密码
     */
    public void restPassword(UserResetPasswordReq req) {
        User user = CopyUtil.copy(req, User.class);
        userMapper.updateByPrimaryKeySelective(user);
    }
}
