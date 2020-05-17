package com.itech.ups.app.business.website.problem.application.service;

import com.itech.ups.app.problem.application.domain.Problem;
import com.itech.ups.app.problem.application.domain.ProblemCategory;
import com.itech.ups.app.problem.application.domain.ProblemReply;

import java.util.List;
import java.util.Map;


public interface ProblemService {

    Problem addProblem(Problem problem);

    ProblemCategory addProblemCategory(ProblemCategory category);

    void editProblem(Problem problem);

    void editProblemCategory(ProblemCategory category);

    void editProblemReply(ProblemReply reply);

    int findCategoriesTotalCount(Map<String, Object> map);

    List<Map<String, String>> findPageProblemCategories(Map<String, Object> map, int rowStart, int rowEnd);

    List<ProblemReply> findPageProblemReplies(Map<String, Object> map, int rowStart, int rowEnd);

    List<Map<String, String>> findPageProblems(Map<String, Object> map, int rowStart, int rowEnd);

    Problem findProblem(String id);

    Problem findProblemByCode(String code);

    List<Map<String, String>> findProblemCategories(Map<String, Object> map);

    List<ProblemCategory> findProblemCategoriesSelect(Map<String, Object> map);

    ProblemCategory findProblemCategory(String id);

    int findProblemRepliesTotalCount(Map<String, Object> map);

    ProblemReply findProblemReply(String id);

    List<Map<String, String>> findProblems(Map<String, Object> map);

    int findProblemsTotalCount(Map<String, Object> map);
}
