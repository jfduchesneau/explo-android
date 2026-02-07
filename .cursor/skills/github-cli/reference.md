# GitHub CLI — Command reference

Use this when you need exact flags or less common subcommands.

## Auth

```bash
gh auth status
gh auth login
gh auth login --with-token   # token from stdin only
gh auth logout
```

## Repo

```bash
gh repo clone owner/repo [dir]
gh repo fork [--remote]
gh repo create [name] --public|--private [--clone] [--source .]
gh repo view [--web]
gh browse [path]
```

## Pull requests

```bash
gh pr create [--title "..." ] [--body "..."] [--fill] [--draft] [--base branch]
gh pr list [--state open|closed|all] [--author @me] [--limit n] [--json number,title,state]
gh pr view [number] [--web]
gh pr checkout <number>
gh pr merge <number> [--merge|--squash|--rebase] [--delete-branch]
gh pr diff [number]
gh pr status
```

## Issues

```bash
gh issue create --title "..." [--body "..."] [--assignee @me] [--label "label"]
gh issue list [--state open|closed|all] [--assignee @me] [--limit n]
gh issue view <number> [--web]
gh issue close <number> [--comment "..."]
```

## Releases

```bash
gh release list
gh release create <tag> [--title "..."] [--notes "..."] [--draft] [files...]
gh release view <tag> [--web]
gh release download <tag>
```

## Workflows and runs

```bash
gh workflow list
gh workflow run <name> [--ref branch] [-f key=value]...
gh run list [--workflow name] [--limit n]
gh run view [run-id] [--web] [--log]
gh run watch [run-id]
gh run rerun [run-id] [--failed]
```

## API and search

- **Raw API**: `gh api /path` or `gh api repos/owner/repo/issues -X POST -f title="..." -f body="..."`
- **Search**: `gh search repos "query"`, `gh search prs "query"`, `gh search issues "query"`

## Non-interactive / scripting

Use these to avoid prompts when the agent runs commands:

- `gh pr create --fill` — use commits for title/body when possible.
- `gh pr merge <n> --squash` (or `--merge`/`--rebase`) — no merge-method prompt.
- `gh release create <tag> --generate-notes` — auto-generate notes.
- `gh repo create name --private --source . --push` — create from current dir and push.

For confirmation prompts, use `--yes` or `-y` where supported (e.g. destructive actions).
