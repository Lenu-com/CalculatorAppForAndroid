# ブランチの作成規則

## ブランチ命名規則

| ブランチ名   | 役割                     | 派生元 | マージ先            |
|--------------|--------------------------|--------|---------------------|
| master       | 公開するものを置くブランチ |        |                     |
| develop      | 開発中のものを置くブランチ | master | master              |
| release      | 次にリリースするものを置くブランチ | develop | develop, master |
| feature-*    | 新機能開発中に使うブランチ | develop | develop             |
| hotfix-*     | 公開中のもののバグ修正用ブランチ | master | develop, master   |

(feature-*やhotfix-*は、*に適当な名前をつける)

---

## 作業手順

1. **新しい機能の追加やバグ修正などの作業を開始する際は、対応するタイプのブランチを選択し、適切な名前でブランチを作成する。**

2. **ブランチ内での作業を行い、コミットを定期的に行う。**

3. **作業が完了したら、他のチームメンバーとのコードレビューやテストを行う。**

4. **問題がなければ、対応する開発ブランチにマージする。**

5. **不要なブランチは定期的に削除する。**

---

## 注意事項

- **ブランチ名には意味があり分かりやすい名前を使用する。**
- **マージ先や派生元は適切に設定し、誤ったブランチにマージしないようにする。**
- **コミットメッセージに関連するIssue番号などを含めることで、タスクの追跡をしやすくする。**