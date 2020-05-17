package com.itech.ups.app.business.website.problem.application.service;

import com.itech.ups.app.business.website.problem.application.infrastructure.ProblemRepository;
import com.itech.ups.app.problem.application.domain.Problem;
import com.itech.ups.app.problem.application.domain.ProblemCategory;
import com.itech.ups.app.problem.application.domain.ProblemReply;
import com.itech.ups.base.application.service.AbstractServiceParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("problemService")
public class ProblemServiceImpl extends AbstractServiceParent implements ProblemService {

    @Autowired
    public ProblemRepository repository;

    @Override
    public Problem addProblem(Problem problem) {
        problem = repository.addProblem(problem);
        return problem;
    }

    @Override
    public ProblemCategory addProblemCategory(ProblemCategory category) {
        category = repository.addProblemCategory(category);
        return category;
    }

    @Override
    public void editProblem(Problem problem) {
        repository.editProblem(problem);
    }

    @Override
    public void editProblemCategory(ProblemCategory category) {
        repository.editProblemCategory(category);
    }

    @Override
    public void editProblemReply(ProblemReply reply) {
        repository.editProblemReply(reply);
    }

    @Override
    public int findCategoriesTotalCount(Map<String, Object> map) {
        int totalCount = repository.findCategoriesTotalCount(map);
        return totalCount;
    }

    @Override
    public List<Map<String, String>> findPageProblemCategories(Map<String, Object> map, int rowStart, int rowEnd) {
        map.put("startNum", rowStart);
        map.put("endNum", rowEnd);
        List<Map<String, String>> categoriesList = repository.findPageProblemCategories(map);
        return categoriesList;
    }

    @Override
    public List<ProblemReply> findPageProblemReplies(Map<String, Object> map, int rowStart, int rowEnd) {
        map.put("startNum", rowStart);
        map.put("rowEnd", rowEnd);
        List<ProblemReply> problemReplyList = repository.findPageProblemReplies(map);
        return problemReplyList;
    }

    @Override
    public List<Map<String, String>> findPageProblems(Map<String, Object> map, int rowStart, int rowEnd) {
        map.put("startNum", rowStart);
        map.put("endNum", rowEnd);
        List<Map<String, String>> problemList = repository.findPageProblems(map);
        return problemList;
    }

    @Override
    public Problem findProblem(String id) {
        Problem problem = repository.findProblem(id);
        return problem;
    }

    @Override
    public Problem findProblemByCode(String code) {
        Problem problem = repository.findProblemByCode(code);
        return problem;
    }

    @Override
    public List<Map<String, String>> findProblemCategories(Map<String, Object> map) {
        List<Map<String, String>> categoryList = repository.findProblemCategories(map);
        return categoryList;
    }

    @Override
    public List<ProblemCategory> findProblemCategoriesSelect(Map<String, Object> map) {
        List<ProblemCategory> categoryList = repository.findProblemCategoriesSelect(map);
        return categoryList;
    }

    @Override
    public ProblemCategory findProblemCategory(String id) {
        ProblemCategory problemCategory = repository.findProblemCategory(id);
        return problemCategory;
    }

    @Override
    public int findProblemRepliesTotalCount(Map<String, Object> map) {
        int totalCount = repository.findProblemRepliesTotalCount(map);
        return totalCount;
    }

    @Override
    public ProblemReply findProblemReply(String id) {
        ProblemReply reply = repository.findProblemReply(id);
        return reply;
    }

    @Override
    public List<Map<String, String>> findProblems(Map<String, Object> map) {
        List<Map<String, String>> problemList = repository.findProblems(map);
        return problemList;
    }

    @Override
    public int findProblemsTotalCount(Map<String, Object> map) {
        int totalCount = repository.findProblemsTotalCount(map);
        return totalCount;
    }

}
