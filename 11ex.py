# Load required library
library(e1071)

# Replace 'your_dataset.csv' with the path to your CSV file
file_path <- 'V:/practice files/spam.csv'

# Load your dataset
your_data <- read.csv(file_path)

# Split the dataset into training and testing sets
set.seed(123) # For reproducibility
trainIndex <- sample(1:nrow(your_data), 0.7 * nrow(your_data)) # 70% for training
trainData <- your_data[trainIndex, ]
testData <- your_data[-trainIndex, ]

# Assuming the last column is the target variable and the rest are features
# If not, modify the formula accordingly
formula <- as.formula(paste(names(your_data)[ncol(your_data)], "~ ."))

# Create a Naive Bayes model
model <- naiveBayes(formula, data = trainData)

# Predict the classes for the test data using the model
predictions <- predict(model, testData)

# Print the predicted classes
print(predictions)

# Evaluate accuracy
accuracy <- mean(predictions == testData[, ncol(testData)])
cat("Accuracy:", accuracy, "\n")


