package com.megagao.production.ssm.service.impl;



import java.util.List;



import com.megagao.production.ssm.domain.COrder;

import com.megagao.production.ssm.domain.COrderExample;

import com.megagao.production.ssm.domain.JobExit;

import com.megagao.production.ssm.domain.JobExitExample;

import com.megagao.production.ssm.domain.customize.CustomResult;


import com.megagao.production.ssm.domain.vo.JobExitVO;

import com.megagao.production.ssm.mapper.JobExitMapper;

import com.megagao.production.ssm.service.JobExitService;

import com.megagao.production.ssm.domain.customize.EUDataGridResult;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import com.github.pagehelper.PageHelper;

import com.github.pagehelper.PageInfo;



@Service

public class JobExitServiceImpl implements JobExitService {



	

	@Autowired

    JobExitMapper jobExitMapper;

	@Override

	public List<JobExitVO> find() throws Exception{

		JobExitExample example = new JobExitExample();

		return jobExitMapper.selectByExample(example);

	}

	

	@Override

	public EUDataGridResult getList(int page, int rows, JobExitVO jobExitVO) throws Exception{

		

		//分页处理

		PageHelper.startPage(page, rows);

		List<JobExitVO> list = jobExitMapper.find(jobExitVO);

		//创建一个返回值对象

		EUDataGridResult result = new EUDataGridResult();

		result.setRows(list);

		//取记录总条数

		PageInfo<JobExitVO> pageInfo = new PageInfo<>(list);

		result.setTotal(pageInfo.getTotal());

		return result;

	}



	@Override

	public JobExitVO get(String id) throws Exception{

		return jobExitMapper.selectByPrimaryKey(id);

	}



	@Override

	public CustomResult delete(String id) throws Exception{

		int i = jobExitMapper.deleteByPrimaryKey(id);

		if(i>0){

			return CustomResult.ok();

		}else{

			return null;

		}

	}



	@Override

	public CustomResult deleteBatch(String[] ids) throws Exception{

		int i = jobExitMapper.deleteBatch(ids);

		if(i>0){

			return CustomResult.ok();

		}else{

			return null;

		}

	}



	@Override

	public CustomResult insert(JobExit jobExit) throws Exception{

		int i = jobExitMapper.insert(jobExit);

		if(i>0){

			return CustomResult.ok();

		}else{

			return CustomResult.build(101, "新增订单失败");

		}

	}



	@Override

	public CustomResult update(JobExit jobExit) throws Exception{

		int i = jobExitMapper.updateByPrimaryKeySelective(jobExit);

		if(i>0){

			return CustomResult.ok();

		}else{

			return CustomResult.build(101, "修改订单失败");

		}

	}



	@Override

	public CustomResult updateAll(JobExit jobExit) throws Exception{

		int i = jobExitMapper.updateByPrimaryKey(jobExit);

		if(i>0){

			return CustomResult.ok();

		}else{

			return CustomResult.build(101, "修改订单失败");

		}

	}



	

	



	

	@Override

	public EUDataGridResult searchJobExitByJobExitId(int page, int rows, String orderId) throws Exception{

		//分页处理

		PageHelper.startPage(page, rows);

		List<JobExitVO> list = jobExitMapper.searchJobExitByJobExitId(orderId);

		//创建一个返回值对象

		EUDataGridResult result = new EUDataGridResult();

		result.setRows(list);

		//取记录总条数

		PageInfo<JobExitVO> pageInfo = new PageInfo<>(list);

		result.setTotal(pageInfo.getTotal());

		return result;

	}

	

	



	@Override

	public EUDataGridResult searchJobExitByJobExitSalary(int page, int rows, String exitSalary)

			throws Exception{

		//分页处理

		PageHelper.startPage(page, rows);

		List<JobExitVO> list = jobExitMapper.searchJobExitByJobExitSalary(exitSalary);

		//创建一个返回值对象

		EUDataGridResult result = new EUDataGridResult();

		result.setRows(list);

		//取记录总条数

		PageInfo<JobExitVO> pageInfo = new PageInfo<>(list);

		result.setTotal(pageInfo.getTotal());

		return result;

	}

}