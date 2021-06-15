package com.liferay.newsletter.portlet.util;

import com.liferay.newsletter.model.Issue;
import com.liferay.newsletter.model.IssueArticle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class IssueUtil {

    public static Map<Issue,ArrayList<IssueArticle>> getAllIssueWithArticle(List<Issue> issues, List<IssueArticle> issueArticles){

        Map<Issue, ArrayList<IssueArticle>> issueWithArticles = new HashMap<>();

        for(int i = 0; i<issues.size(); i++){
            int finalI = i;
            ArrayList<IssueArticle> temp = (ArrayList<IssueArticle>) issueArticles.stream().
                    filter(issueArticle -> issueArticle.getIssueNumber()==issues.get(finalI).getIssueNumber()).collect(Collectors.toList());

            issueWithArticles.put(issues.get(finalI),temp);
        }

        return issueWithArticles;
    }

    public static List<Issue> getIssueSearchPagination(List<Issue> issues, int start, int end){

        List<Issue> issueSearch = new ArrayList<>();
        int listSize = issues.size();

        if(start >= listSize){
            for(int i = 0; i < listSize; i++){
                issueSearch.add(issues.get(i));
            }
        } else if(end >= listSize){
            for(int i = start; i < listSize; i++){
                issueSearch.add(issues.get(i));
            }
        } else {
            for(int i = start; i < end; i++){
                issueSearch.add(issues.get(i));
            }
        }
        return issueSearch;
    }

    public static Map<Issue,ArrayList<IssueArticle>> getAllIssueWithArticleByDate(List<Issue> issues, List<IssueArticle> issueArticles,String dateString) throws ParseException {
        Map<Issue, ArrayList<IssueArticle>> issueWithArticlesByDate = new HashMap<>();
        List<Issue> issuesByDate;

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);

        issuesByDate = issues.stream()
                .filter(issue -> issue.getIssueDate().getMonth()==date.getMonth()&& issue.getIssueDate().getYear()==date.getYear())
                .sorted(Comparator.comparing(Issue::getIssueDate))
                .collect(Collectors.toList());

        for(int i = 0; i<issuesByDate.size(); i++){
            int finalI = i;
            ArrayList<IssueArticle> temp = (ArrayList<IssueArticle>) issueArticles.stream()
                    .filter(issueArticle -> issueArticle.getIssueNumber()== issuesByDate.get(finalI).getIssueNumber())
                    .collect(Collectors.toList());

            issueWithArticlesByDate.put(issuesByDate.get(finalI),temp);
        }
        return issueWithArticlesByDate;
    }

    public static Map<Issue,ArrayList<IssueArticle>> getIssueWithArticleByIssueNumber(List<Issue> issues, List<IssueArticle> issueArticles, long issueNumber){
        Map<Issue, ArrayList<IssueArticle>> issueWithArticles = new HashMap<>();
        Issue issueByNumber = issues.stream().filter(issue->issue.getIssueNumber()==issueNumber).findAny().orElse(null);
        if(issueByNumber==null){
            return null;
        } else {
            ArrayList<IssueArticle> temp = (ArrayList<IssueArticle>) issueArticles.stream()
                    .filter(issueArticle -> issueArticle.getIssueNumber() == issueByNumber.getIssueNumber())
                    .collect(Collectors.toList());

            issueWithArticles.put(issueByNumber, temp);
            return issueWithArticles;
        }
    }

    public static List<String> yearsOfIssue (List<Issue> issues){
        List<String> years = new ArrayList<>();
        if(issues == null){
            return null;
        }
        issues = issues.stream().sorted(Comparator.comparing(Issue::getIssueDate)).collect(Collectors.toList());
        int yearEnd = issues.get(issues.size()-1).getIssueDate().getYear()+1900;
        int yearBegin = issues.get(0).getIssueDate().getYear()+1900;
        while(yearBegin <= yearEnd){
            years.add(String.valueOf(yearBegin));
            yearBegin++;
        }
        return years;
    }
}
