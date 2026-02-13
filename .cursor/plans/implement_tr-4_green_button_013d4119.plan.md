---
name: Implement TR-4 Green Button
overview: Implement Linear issue TR-4 by adding a green button to the existing HelloWorld screen that displays "Green!" when clicked, following the same UDF pattern as the existing Red button, plus theme color, tests, and branch setup.
todos: []
isProject: false
---

# Implement TR-4: Add a Green button which displays "Green!"

## Linear issue

- **TR-4**: Add a Green button which displays "Green!"
- **Status**: Todo (set to "In Progress" when starting work)
- **Suggested branch**: Linear suggests `jfduchesneau/tr-4-add-a-green-button-which-displays-green`; per [new-git-feature-branch](.cursor/commands/new-git-feature-branch.md) use a branch starting with `feature/` and at most 50 characters (e.g. `feature/tr-4-green-button`).

## Current architecture

The app uses a single HelloWorld feature with UDF:

- **[HelloWorldScreen.kt](app/src/main/java/com/example/exploandroid/helloworld/HelloWorldScreen.kt)**: Compose UI with an "Action" button (blue) and a "Red" button; `uiState.message` is shown below when set.
- **[HelloWorldViewModel.kt](app/src/main/java/com/example/exploandroid/helloworld/HelloWorldViewModel.kt)**: Handles `OnActionButtonClick` → "Hello World", `OnRedButtonClick` → "Red!".
- **[HelloWorldEvent.kt](app/src/main/java/com/example/exploandroid/helloworld/HelloWorldEvent.kt)**: Sealed interface with button events.
- **[Color.kt](app/src/main/java/com/example/exploandroid/ui/theme/Color.kt)**: Defines `ActionBlue`, `ActionRed` (no green yet).

The Green button will follow the exact same pattern as the Red button.

## Implementation steps

### 1. Process and branch (when executing)

- Set Linear issue TR-4 status to **In Progress**.
- Create feature branch from `main`: name `feature/tr-4-green-button` (or equivalent, prefix `feature/`, length ≤ 50).

### 2. Theme: add green color

- In [Color.kt](app/src/main/java/com/example/exploandroid/ui/theme/Color.kt), add:
  - `val ActionGreen = Color(0xFF4CAF50)` (Material green 500).

### 3. Event and ViewModel

- In [HelloWorldEvent.kt](app/src/main/java/com/example/exploandroid/helloworld/HelloWorldEvent.kt), add:
  - `data object OnGreenButtonClick : HelloWorldEvent`
- In [HelloWorldViewModel.kt](app/src/main/java/com/example/exploandroid/helloworld/HelloWorldViewModel.kt), in `onEvent`, add:
  - `is HelloWorldEvent.OnGreenButtonClick -> _uiState.update { it.copy(message = "Green!") }`

### 4. UI: Green button

- In [HelloWorldScreen.kt](app/src/main/java/com/example/exploandroid/helloworld/HelloWorldScreen.kt):
  - Import `ActionGreen` from theme.
  - Add a third `Button` after the Red button: green container color (`ButtonDefaults.buttonColors(containerColor = ActionGreen)`), text `"Green"`, `onClick = { onEvent(HelloWorldEvent.OnGreenButtonClick) }`, same top padding as Red. The existing `uiState.message` block already displays "Green!" when set.

### 5. Tests

- **Unit test** in [HelloWorldViewModelTest.kt](app/src/test/java/com/example/exploandroid/HelloWorldViewModelTest.kt):
  - Add test: `onGreenButtonClick_setsMessageToGreen()` — send `HelloWorldEvent.OnGreenButtonClick`, assert `viewModel.uiState.value.message == "Green!"`.
- **UI test** in [HelloWorldScreenTest.kt](app/src/androidTest/java/com/example/exploandroid/HelloWorldScreenTest.kt):
  - Add test: `greenButton_click_displaysGreen()` — find node with text "Green", performClick(), assert "Green!" is displayed.

### 6. Code review and finish

- Run through [code-review-checklist](.cursor/commands/code-review-checklist.md) (functionality, code quality, security, testing).
- Optionally add a Compose preview that shows the Green button or a state with message "Green!" for consistency with existing previews.

## Files to touch


| File                                                                                                   | Change                                 |
| ------------------------------------------------------------------------------------------------------ | -------------------------------------- |
| [Color.kt](app/src/main/java/com/example/exploandroid/ui/theme/Color.kt)                               | Add `ActionGreen`                      |
| [HelloWorldEvent.kt](app/src/main/java/com/example/exploandroid/helloworld/HelloWorldEvent.kt)         | Add `OnGreenButtonClick`               |
| [HelloWorldViewModel.kt](app/src/main/java/com/example/exploandroid/helloworld/HelloWorldViewModel.kt) | Handle `OnGreenButtonClick` → "Green!" |
| [HelloWorldScreen.kt](app/src/main/java/com/example/exploandroid/helloworld/HelloWorldScreen.kt)       | Add Green button + import              |
| [HelloWorldViewModelTest.kt](app/src/test/java/com/example/exploandroid/HelloWorldViewModelTest.kt)    | Add unit test for green button         |
| [HelloWorldScreenTest.kt](app/src/androidTest/java/com/example/exploandroid/HelloWorldScreenTest.kt)   | Add UI test for green button           |


No new screens or ViewModels; no Hilt or repository changes. This keeps the change minimal and consistent with the existing Red button implementation.