package com.supertool.dspui.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.dao.zhongpai.UserMapper;
import com.supertool.dspui.model.User;
import com.supertool.dspui.param.form.PasswordForm;
import com.supertool.dspui.param.form.PersonalInfoForm;
import com.supertool.dspui.util.SHAEncrypter;
import com.supertool.dspui.vo.PersonalInfoVO;
import com.supertool.dspui.vo.ResultVO;

@Service
public class PersonalInfoService {
	
	@Autowired
	private UserMapper userMapper;
	
	public ResultVO updatePersonalInfo(PersonalInfoForm personalInfoForm) {
		ResultVO resultVO = new ResultVO();
		User user = userMapper.findByUserName(UserContext.getLoginUser().getUsername());
		user.setUsername(personalInfoForm.getUsername().trim());
		user.setUserFullName(personalInfoForm.getUserFullName().trim());
		user.setPhoneNumber(personalInfoForm.getPhoneNumber().trim());
		user.setEmail(personalInfoForm.getEmail().trim());
		user.setAddress(personalInfoForm.getAddress().trim());
		user.setWebsite(personalInfoForm.getWebsite().trim());
		user.setZipcode(personalInfoForm.getZipcode().trim());
		user.setDescription(personalInfoForm.getDescription().trim());
		int result = userMapper.update(user);
		
		if(result > 0){
			resultVO.setMessage("操作成功!");
			resultVO.setResultCode(1);
		}else{
			throw new RuntimeException("本地更新用户信息失败！");		
		}
		return resultVO;
	}

	public PersonalInfoVO getPersonalInfoVO() {
		
		User user = userMapper.findByUserName(UserContext.getLoginUser().getUsername());
		PersonalInfoVO personalInfoVO = new PersonalInfoVO();
		personalInfoVO.setUsername(user.getUsername());
		personalInfoVO.setUserFullName(user.getUserFullName());
		personalInfoVO.setPhoneNumber(user.getPhoneNumber());
		personalInfoVO.setEmail(user.getEmail());
		personalInfoVO.setAddress(user.getAddress());
		personalInfoVO.setZipcode(user.getZipcode());
		personalInfoVO.setWebsite(user.getWebsite());
		personalInfoVO.setDescription(user.getDescription());
		return personalInfoVO;
	}

	public ResultVO updatePassword(PasswordForm passwordForm) {
		ResultVO resultVO = new ResultVO();
		if(passwordForm.getNewPassword().equals(passwordForm.getConfirmPassword())) {
			int result = userMapper.updateUserPasswordByName(passwordForm.getUsername(), SHAEncrypter.getInstance().encrypt(passwordForm.getNewPassword()));
			
			if(result > 0){
				resultVO.setMessage("操作成功!");
				resultVO.setResultCode(1);
			}else{
				throw new RuntimeException("本地更新用户信息失败！");		
			}
		}
		return resultVO;
	}

	public boolean check(Map<String, String> map) {
		if(map.containsKey("oldPassword")) {
			String oldPassword = userMapper.findByUserName(UserContext.getLoginUser().getUsername()).getPassword();
			String testPassword = SHAEncrypter.getInstance().encrypt(map.get("oldPassword"));
			if(testPassword.equals(oldPassword)) {
				return true;
			}
		}
		return false;
	}
	
}
