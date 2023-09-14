package kr.co.hit.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hit.dao.CommunityDao;
import kr.co.hit.dto.CommunityDto;

@Service
public class CommunityService implements CommunityDao {

	@Autowired
	private SqlSession sqlsession;

	@Override
	public List<CommunityDto> CommunityList() {
		
		CommunityDao dao = sqlsession.getMapper(CommunityDao.class);
		List<CommunityDto> list = new ArrayList<CommunityDto>();
		list = dao.CommunityList();

		return list;

	}

	@Override
	public void InsertCommunity(CommunityDto dto) {
		
//		CommunityService dao = sqlsession.getMapper(CommunityService.class);
		CommunityDao dao = sqlsession.getMapper(CommunityDao.class);
		dao.InsertCommunity(dto);

	}

	@Override
	public CommunityDto getCommunityDetail(int b_no) {
	
		CommunityDao dao = sqlsession.getMapper(CommunityDao.class);	
		return dao.getCommunityDetail(b_no);
	}

	public int updateCommunity(CommunityDto dto) {

		CommunityDao dao = sqlsession.getMapper(CommunityDao.class);
		return dao.updateCommunity(dto);
		
	}

}
