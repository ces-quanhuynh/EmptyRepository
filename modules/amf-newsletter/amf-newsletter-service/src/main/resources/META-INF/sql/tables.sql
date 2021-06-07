create table NL_Issue (
	uuid_ VARCHAR(75) null,
	issueId LONG not null primary key,
	issueNumber LONG,
	title VARCHAR(75) null,
	description STRING null,
	issueDate DATE null
);

create table NL_IssueArticle (
	uuid_ VARCHAR(75) null,
	issueArticleId LONG not null primary key,
	issueNumber LONG,
	title VARCHAR(75) null,
	author VARCHAR(75) null,
	order_ LONG,
	content STRING null
);