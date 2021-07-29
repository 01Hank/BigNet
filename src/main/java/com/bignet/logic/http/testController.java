package com.bignet.logic.http;

import com.bignet.db.entity.impl.User;
import com.bignet.db.mapper.UserMapper;
import com.bignet.util.SpringUtil;
import com.bignet.util.UUIDGenerate;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/test")
public class testController {
    private static final Logger log = LoggerFactory.getLogger(testController.class);

    @Autowired
    private UserMapper userMapper;


    @GetMapping("/get")
    @ResponseBody
    public String test(){
        log.info("request is suc!");
        SpringUtil.isInit();
        return "hello world";
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<User> getAllUser(){
        List<User> allUser = userMapper.findAll();
        for(User user:allUser){
            byte[] decode = Base64.decodeBase64(user.getData());
            if(decode != null){
                System.out.println(new String(decode));
            }
        }
        return allUser;
    }

    @GetMapping("/saveUser")
    @ResponseBody
    public String saveUser(){
        User user = new User();
        user.setName("yst");
        user.setUid(UUIDGenerate.getUUID());
        user.setPassward(123456);
        user.setEmail("12@qq.com");
        String data = "hello";
        try {
            byte[] encode = Base64.encodeBase64(data.getBytes("UTF-8"));
            user.setData(encode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        userMapper.save(user);
        return "suc";
    }

    /**
     * 表是否存在
     * @return
     */
    @GetMapping("/initTable")
    @ResponseBody
    public void initTable(){
        userMapper.initTable();
    }

    /**
     * 获取单个用户
     * @return
     */
    @GetMapping("/getUser")
    @ResponseBody
    public List<User> getUser(int uid){
        List<User> data = userMapper.getData(uid);
        return data;
    }
}
