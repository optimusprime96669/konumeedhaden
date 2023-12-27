from mlxtend.frequent_patterns import apriori
from mlxtend.frequent_patterns import association_rules
import pandas as pd

# Sample transaction dataset (replace this with your dataset)
data = {
    'Transaction': [1, 1, 1, 2, 2, 3, 4, 4, 5],
    'Items': ['A', 'B', 'C', 'A', 'B', 'B', 'A', 'C', 'A']
}

df = pd.DataFrame(data)

# Convert the transaction dataset into a one-hot encoded format
one_hot_encoded = pd.get_dummies(df['Items'])

# Concatenate the one-hot encoded dataframe with the original dataframe
df = pd.concat([df['Transaction'], one_hot_encoded], axis=1)

# Find frequent item sets with minimum support of 0.2 (adjust the support threshold as needed)
frequent_itemsets = apriori(df.drop(columns='Transaction'), min_support=0.2, use_colnames=True)

# Generate association rules with minimum threshold for lift and confidence
rules = association_rules(frequent_itemsets, metric='lift', min_threshold=1)

print("Frequent Item Sets:")
print(frequent_itemsets)
print("\nAssociation Rules:")
print(rules)
