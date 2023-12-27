# Load the arules package
library(arules)

# Example transaction dataset (replace this with your own dataset)
transactions <- read.transactions(file = "V:/Iris.csv", format = "basket", sep = ",")

# Run Apriori algorithm
rules <- apriori(transactions, parameter = list(support = 0.1, confidence = 0.6))

# Show the generated rules
inspect(rules)
