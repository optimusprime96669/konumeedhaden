# Load the iris dataset
data(iris)

# Perform k-means clustering on a subset of iris data (for demonstration purposes)
# Here, we select two features 'Sepal.Length' and 'Sepal.Width'
selected_features <- iris[, c("Sepal.Length", "Sepal.Width")]

# Perform k-means clustering with k=3 (number of clusters)
set.seed(123)  # Setting seed for reproducibility
kmeans_result <- kmeans(selected_features, centers = 3)

# Print cluster centers and within-cluster sum of squares
print("Cluster Centers:")
print(kmeans_result$centers)

print("\nWithin-Cluster Sum of Squares:")
print(kmeans_result$tot.withinss)

# Plotting the clusters (for 2D data)
plot(selected_features, col = kmeans_result$cluster)
points(kmeans_result$centers, col = 1:3, pch = 8, cex = 2)
