create table beadando.person_company(
    person_company_id   bigint identity(1,1) primary key,
    person_id           bigint not null FOREIGN KEY REFERENCES beadando.person(person_id),
    company_id          bigint not null FOREIGN KEY REFERENCES beadando.company(company_id),
    date                date not null

);
