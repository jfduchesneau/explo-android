---
name: github-cli
description: Use GitHub CLI (gh) for GitHub interactions from the terminal. Use when creating or managing pull requests, issues, repos, releases, workflows, or when the user asks to use gh, GitHub CLI, or perform GitHub operations from the command line.
---

# GitHub CLI (gh)

Use the `gh` command for GitHub operations instead of raw `curl` or manual git remote workflows. Prefer `gh` when the task involves PRs, issues, repos, releases, or Actions.

## Before Running gh

1. **Auth**: Ensure the user is logged in. If unsure, run `gh auth status`. To log in: `gh auth login` (interactive). Use `gh auth login --with-token` only when feeding a token from stdin; never embed tokens in commands or scripts.
2. **Repo context**: Most commands assume current directory is a git repo with a GitHub remote. For other repos use `--repo owner/name` or run from that repo.

## Core Workflows

### Repositories

- Clone: `gh repo clone owner/repo [directory]`
- Fork (from inside repo): `gh repo fork [--remote]`
- Create: `gh repo create [name] [--public|--private] [--clone]`
- View in browser: `gh browse` or `gh browse path/to/file`

### Pull requests

- Create (from current branch): `gh pr create [--title "..." ] [--body "..."]` — use `--fill` to use commit messages.
- List: `gh pr list [--state open|closed|all] [--author @me] [--limit n]`
- View one: `gh pr view [number]` or `gh pr view --web`
- Checkout: `gh pr checkout <number>`
- Merge: `gh pr merge <number> [--merge|--squash|--rebase]`
- Diff: `gh pr diff [number]`

### Issues

- Create: `gh issue create --title "..." [--body "..."] [--assignee @me]`
- List: `gh issue list [--state open|closed|all] [--assignee @me]`
- View: `gh issue view <number>` or `gh issue view --web`

### Releases

- List: `gh release list`
- Create: `gh release create <tag> [--title "..."] [--notes "..."] [files...]`
- View: `gh release view <tag>`

### GitHub Actions

- List workflows: `gh workflow list`
- Run workflow: `gh workflow run <name> [--ref branch] [-f key=value]...`
- List runs: `gh run list [--workflow name] [--limit n]`
- View run: `gh run view [run-id]` or `gh run view --web`
- Watch run: `gh run watch`

## General Rules

- **Help**: Use `gh <command> --help` or `gh help <command>` for options. Prefer checking help over guessing flags.
- **Non-interactive**: In scripts or when the agent runs commands, use explicit flags (e.g. `--title`, `--body`, `--yes`) to avoid prompting.
- **Safety**: Never suggest or emit commands that pass tokens, passwords, or secrets as arguments or in scripts. Use `gh auth login` or `--with-token` from stdin only.
- **Repo flag**: When not in the target repo, always pass `--repo owner/name` for commands that support it.

## Output and scripting

- Many commands support `--json <fields>` for JSON output; combine with `--jq '<expression>'` for filtering (if jq is available).
- Use `-q` / `--jq` for stable parsing in automation; avoid scraping human-readable output.

## Additional reference

For more subcommands and options (e.g. `gh api`, `gh search`, `gh secret`, `gh variable`), see [reference.md](reference.md).
