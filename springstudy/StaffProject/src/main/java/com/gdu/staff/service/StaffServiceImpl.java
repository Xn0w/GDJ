package com.gdu.staff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gdu.staff.domain.StaffDTO;
import com.gdu.staff.mapper.StaffMapper;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffMapper staffMapper;
	
	@Override
	public List<StaffDTO> getStaffList() {
		
		return staffMapper.selectStaffList();
	}

	@Override
	public ResponseEntity<String> addStaff(StaffDTO staff) {
		
		try {
			staff.setSalary(4000);
			staffMapper.insertStaff(staff);
			return new ResponseEntity<String>("사원 등록이 성공했습니다.", HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>("사원 등록이 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	public ResponseEntity<String> searchStaff(StaffDTO staff) {
		try {
			return new ResponseEntity<String>("조회에 성공했습니다.", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("조회에 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
}
