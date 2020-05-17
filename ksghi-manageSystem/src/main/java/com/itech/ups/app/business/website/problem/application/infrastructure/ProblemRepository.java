package com.itech.ups.app.business.website.problem.application.infrastructure;

import com.itech.ups.app.problem.application.domain.Problem;
import com.itech.ups.app.problem.application.domain.ProblemCategory;
import com.itech.ups.app.problem.application.domain.ProblemReply;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ProblemRepository extends AbstractRepositoryParent {

    public Problem addProblem(Problem problem) {
        problem.setId(generateIdentifier());
        problem = (Problem) sqlMapClientTemplate.insert("problem.insertProblem", problem);
        return problem;
    }

    public ProblemCategory addProblemCategory(ProblemCategory category) {
        category.setId(generateIdentifier());
        category = (ProblemCategory) sqlMapClientTemplate.insert("problem.insertProblemCategory", category);
        return category;
    }

    public void editProblem(Problem problem) {
        sqlMapClientTemplate.update("problem.updateProblem", problem);
    }

    public void editProblemCategory(ProblemCategory category) {
        sqlMapClientTemplate.update("problem.updateProblemCategory", category);
    }

    public void editProblemReply(ProblemReply reply) {
        sqlMapClientTemplate.update("problem.updateProblemReply", reply);
    }

    public int findCategoriesTotalCount(Map<String, Object> map) {
        int totalCount = (Integer) sqlMapClientTemplate.queryForObject("problem.findProblemCategoriesTotalCount", map);
        return totalCount;
    }

    public List<Map<String, String>> findPageProblemCategories(Map<String, Object> map) {
        return sqlMapClientTemplate.queryForList("problem.findPageProblemCategories", map);
    }

    public List<ProblemReply> findPageProblemReplies(Map<String, Object> map) {
        List<ProblemReply> problemReplyList = sqlMapClientTemplate.queryForList("problem.findPageProblemReplies", map);
        return problemReplyList;
    }

    public List<Map<String, String>> findPageProblems(Map<String, Object> map) {
        List<Map<String, String>> problemList = sqlMapClientTemplate.queryForList("problem.findPageProblems", map);
        return problemList;
    }

    public Problem findProblem(String id) {
        Problem problem = (Problem) sqlMapClientTemplate.queryForObject("problem.findProblem", id);
        return problem;
    }

    public Problem findProblemByCode(String code) {
        Problem problem = (Problem) sqlMapClientTemplate.queryForObject("problem.findProblemByCode", code);
        return problem;
    }

    public List<Map<String, String>> findProblemCategories(Map<String, Object> map) {
        List<Map<String, String>> problemCategoryList = sqlMapClientTemplate.queryForList("problem.findProblemCategories", map);
        return problemCategoryList;
    }

    public List<ProblemCategory> findProblemCategoriesSelect(Map<String, Object> map) {
        List<ProblemCategory> problemCategory = sqlMapClientTemplate.queryForList("problem.findProblemCategoriesSelect", map);
        return problemCategory;
    }

    public ProblemCategory findProblemCategory(String id) {
        ProblemCategory problemCategory = (ProblemCategory) sqlMapClientTemplate.queryForObject("problem.findProblemCategory", id);
        return problemCategory;
    }

    public int findProblemRepliesTotalCount(Map<String, Object> map) {
        int totalCount = (Integer) sqlMapClientTemplate.queryForObject("problem.findProblemRepliesTotalCount", map);
        return totalCount;
    }

    public ProblemReply findProblemReply(String id) {
        ProblemReply reply = (ProblemReply) sqlMapClientTemplate.queryForObject("problem.findProblemReply", id);
        return reply;
    }

    public List<Map<String, String>> findProblems(Map<String, Object> map) {
        List<Map<String, String>> problemList = sqlMapClientTemplate.queryForList("problem.findProblems", map);
        return problemList;
    }

    public int findProblemsTotalCount(Map<String, Object> map) {
        int totalCount = (Integer) sqlMapClientTemplate.queryForObject("problem.findProblemsTotalCount", map);
        return totalCount;
    }

}
