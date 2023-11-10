# oopp-grupp22

## How To

### Pull Request

1. Save and stash eventual changes that are not committed
2. `git switch main`
3. `git pull`
4. `git switch [feature branch]`
5. `git rebase main`
6. Pop eventual stash
7. Handle conflicts
8. DO NOT PUSH/PULL at this point if there are any upstream changes
9. `git push --force-with-lease` if the branch is already on the remote. Otherwise publish the branch.
10. Create a pull request on GitHub
11. Link relevant issue
12. Resolve comments
13. Merge
