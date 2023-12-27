# Load required library
library(e1071)

# Load the Iris dataset (built-in dataset in R)
data(iris)

# Split the dataset into training and testing sets
set.seed(123) # For reproducibility
trainIndex <- sample(1:nrow(iris), 0.7 * nrow(iris)) # 70% for training
trainData <- iris[trainIndex, ]
testData <- iris[-trainIndex, ]

# Create a Naive Bayes model
model <- naiveBayes(Species ~ ., data = trainData)

# Predict the classes for the test data using the model
predictions <- predict(model, testData)

# Print the predicted classes
print(predictions)

# Evaluate accuracy
accuracy <- mean(predictions == testData$Species)
cat("Accuracy:", accuracy, "\n")
