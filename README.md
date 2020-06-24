# knn-recruitmentbot
A Recruitment bot that uses K-Nearest Neighbors Algorithm to determine whether you should hire the applicant or not

It uses the data in sample_data.txt as sample to find the older applicants with scores near to new applicant.

# Candidate.java
Candidate class with scores(social, algorithm, gpa, age) out of 5 and hired( 1 for hired, 0 for not hired).
It also has a distance property that will be objects Euclidean distance to new applicant's scores.

# Program.java
It takes scores of the candidate and k number for k-nearest neighbors algorithm from user, calculates the Euclidean distance of each applicant's score.

Then it sorts the applicants by Euclidean distance to new candidate with merge sort, searches the k-nearest neighbors and if more than half of that applicants are hired, it hires the new applicant.

# AccuracyTest.java
It tests the accuracy of the program by executing the program on each applicant from the sample data.
In this case, accuracy was 99.8% .
