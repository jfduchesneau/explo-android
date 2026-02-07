---
name: create-pr
description: Create a well-structured pull request
---

Create a pull request for the current changes.

- If current git branch is "main" or "develop", create a new feature branch so that changes are committed in the feature branch
- Look at the staged and unstaged changes.
- Write a clear commit message based on what changed
- Commit and push to the current branch
- Open a pull request with a clear title/description
- If a Linear issue is associated with this work, include the issue id in the pr description
- Update Linear issue status, if any, to "In Review"
- Return the PR URL when done, but do not open it in a browser